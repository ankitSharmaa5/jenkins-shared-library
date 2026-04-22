package com.company.deploy

class DeploymentManager implements Serializable {

    def steps

    DeploymentManager(steps) {
        this.steps = steps
    }

    def validate(String env) {
        steps.echo "Validating deployment for ${env}..."

        if (!(env in ['dev', 'staging', 'prod'])) {
            steps.error("Invalid environment: ${env}")
        }

        steps.echo "Validation successful for ${env}"
    }

    def deploy(String env) {
        steps.echo "Deploying application to ${env}..."

        if (env == 'dev') {
            steps.sh "echo Deploying DEV environment"
        } else if (env == 'staging') {
            steps.sh "echo Deploying STAGING environment"
        } else if (env == 'prod') {
            steps.sh "echo Deploying PRODUCTION environment"
        }

        steps.echo "Deployment completed for ${env}"
    }

    def rollback(String env) {
        steps.echo "Rolling back deployment in ${env}..."
        steps.sh "echo Rolling back ${env}"
        steps.echo "Rollback completed for ${env}"
    }
}