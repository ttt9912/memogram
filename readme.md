# Frontend

## PrimeNG

### Prime Icons
https://www.primefaces.org/primeng/#/icons
- icons
- spinner

### Grid CSS
Grid CSS is a lightweight responsive layout utility optimized for mobile devices, tablets and desktops.

https://www.primefaces.org/showcase/ui/panel/grid.xhtml

https://primefaces.github.io/primefaces/8_0/#/components/gridcss

## Fontawesome
1.) install (package.json)  
`$ npm install --save @fortawesome/fontawesome-free`

2.) include (
- angular.json styles section
- or styles.scss

## Bootstrap
### Spacing
https://getbootstrap.com/docs/4.0/utilities/spacing/

- `m` - margin
- `p` - padding

`mb` - margin-top, etc.



# Heroku

## Heroku CLI
`$ heroku apps` - list apps

`$ heroku apps:info -a <APP_NAME>` - url, git, etc.

`$ memogram-app-jsonstore % heroku run printenv -a <APP_NAME>` - port, JAVA_OPTS,
environment variables, etc.


## Deploy Sourcecode
- Use Github deployments
- **Procfile** - defines what to do after build completed
- **system.properties File** - set java version 11 etc.


## Deploy Docker Container
There are two ways of how to use Docker on Heroku. 

- **Heroku Container Registry** - build images locally and push them
to Heroku registry

- **heroku.yml** - push sources to heroku git repository 
`git push heroku master` and let heroku build the images

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

## Heroku Postgres

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

just use them in `application.yml`

## Procfile TODO
setting environment variables

