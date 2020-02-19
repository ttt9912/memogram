# Heroku CLI
`$ heroku apps` - list apps

`$ heroku apps:info -a <APP_NAME>` - url, git, etc.

`$ memogram-app-jsonstore % heroku run printenv -a <APP_NAME>` - port, JAVA_OPTS,
environment variables, etc.

# Deploy to Heroku

## GitHub Deployment
- Use Github deployments
- **Procfile** - defines what to do after build completed
- **system.properties File** - set java version 11 etc.
- **spring-boot-maven-plugin** - included in app pom


## Docker Container Deployment
There are two ways of how to use Docker on Heroku. 

- **heroku.yml** - push sources to heroku git repository 
`git push heroku master` and let heroku build the images

- **Heroku Container Registry** - build images locally and push them
to Heroku registry


## Deploy with heroku.yml


## Deploy with Heroku Container Registry

### Build Docker Image
- add Dockerfile
- use dockerfile-maven-plugin

#### Build manually from cli
navigate to Dockerfile directory

`$ docker build -t memogram-app .`

`$ docker run -p 8080:8080 -t memogram-app`

set $PORT for Heroku in the Dockerfile

`$ docker run -e "PORT=8080" -t memogram-app`

### Deploy Docker Image to Heroku
https://dashboard.heroku.com/apps/memogram-trial/deploy/heroku-container

#### Login
`$ heroku container:login`

#### Push Image
navigate to Dockerfile directory

**`$ heroku container:push web -a <HEROKU_APP_NAME>`**  
`$ heroku container:push web -a memogram-trial`

#### Release
`$ heroku container:release web -a memogram-trial`




# Heroku Postgres

### Tiers & Plans
https://devcenter.heroku.com/articles/heroku-postgres-plans#premium-tier

#### Pricing
https://elements.heroku.com/addons/heroku-postgresql

#### Hobby Tier
Available Plans: **hobby-dev** and **hobby-basic**

### Add Postgres Addon
**`$ heroku addons:create heroku-postgresql:<PLAN_NAME> -a <APP_NAME>`**  
`$ heroku addons:create heroku-postgresql:hobby-dev -a memogram-trial`

`DATABASE_URL` config var is added to your app’s configuration

#### show config vars
`$ heroku config -a <APP_NAME>`

#### Postgres info
`$ heroku pg:info -a <APP_NAME>`

### Spring connection properties
https://devcenter.heroku.com/articles/connecting-to-relational-databases-on-heroku-with-java#using-the-spring_datasource_url-in-a-spring-boot-app

Heroku will automatically populate the environment variables 
- `SPRING_DATASOURCE_URL`
- `SPRING_DATASOURCE_USERNAME`
- `SPRING_DATASOURCE_PASSWORD`

- `JDBC_DATABASE_URL`
- `JDBC_DATABASE_USERNAME`
- `JDBC_DATABASE_PASSWORD`

just use them in `application.yml` (does not directly work with containers)

