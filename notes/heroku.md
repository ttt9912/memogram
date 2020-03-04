# Heroku CLI
`$ heroku apps` - list apps

`$ heroku apps:info -a <HEROKU_APP_NAME>` - url, git, etc.

`$ heroku run printenv -a <HEROKU_APP_NAME>` - port, JAVA_OPTS,
environment variables, etc.

`$ heroku logs -a <HEROKU_APP_NAME> -t` - logs as continuous stream


# Deploy to Heroku

## GitHub Deployment
- Use Github deployments
- `$ heroku stack:set heroku-18 -a <HEROKU_APP_NAME>`
- **Procfile** - defines what to do after build completed
- **system.properties file** - set java version 11 etc.
- **spring-boot-maven-plugin** - included in app pom

### Procfile
location: root folder

content:
```text
web: java -jar -Dserver.port=$PORT memogram-apps/memogram-app-postgres/target/memogram-app-postgres-0.0.1-SNAPSHOT.jar
```

### system.properties file
location: root folder

content:
```text
java.runtime.version=11
```

## Docker Container Deployment
There are two ways of how to use Docker on Heroku. 

- **heroku.yml** - push sources to heroku git repository 
`git push heroku master` and let heroku build the images

- **Heroku Container Registry** - build images locally and push them
to Heroku registry


## Deploy with heroku.yml

### 1. set stack to container
`$ heroku stack:set container`

### 2. Create heroku.yml
- `setup` - Specifies the **add-ons** and **config vars**

- `build` - Specifies the `Dockerfile` to build. 

**Build config vars**: the `config` field of the build section allows 
you set environment variables available to the build environment. 
Variables set in this section do not create runtime config vars. 
Also runtime config vars (e.g., those set with heroku config:set) are 
not available at build-time.

- `release` - 

- `run` - without `run` section, Heroku uses the `CMD` specified in 
the `Dockerfile`.

### 3. Register heroku Git repo
`$ heroku git:remote -a <HEROKU_APP_NAME>`

### 4. push to heroku Git repo
`$ git push heroku master`

Heroku will use `run` command from `heroku.yml` (resp. 
`CMD` from `Dockerfile`) instead of `Procfile`.



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
`$ heroku container:release web -a <HEROKU_APP_NAME>`




# Heroku Postgres

### Tiers & Plans
https://devcenter.heroku.com/articles/heroku-postgres-plans#premium-tier

#### Pricing
https://elements.heroku.com/addons/heroku-postgresql

#### Hobby Tier
Available Plans: **hobby-dev** and **hobby-basic**

### Add Postgres Addon
**`$ heroku addons:create heroku-postgresql:<PLAN_NAME> -a <HEROKU_APP_NAME>`**  
`$ heroku addons:create heroku-postgresql:hobby-dev -a memogram-trial`

`DATABASE_URL` config var is added to your app’s configuration

#### show config vars
`$ heroku config -a <HEROKU_APP_NAME>`

#### Postgres info
`$ heroku pg:info -a <HEROKU_APP_NAME>`

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

