package com.company.deploy

class DeploymentManager implements Serializable {

    def steps

    DeploymentManager(steps) {
        this.steps = steps
    }

    // ✅ Validation Method
    def validate(String env) {
        steps.echo "Validating deployment for ${env}..."

        if (!(env in ['dev', 'staging', 'prod'])) {
            steps.error "Invalid environment: ${env}"
        }

        steps.echo "Validation successful for ${env}"
    }

    // 🚀 Deployment Method
    def deploy(String env) {
        steps.echo "Deploying application to ${env}..."

        if (env == 'dev') {
            steps.sh "echo Deploying to DEV server"
        } else if (env == 'staging') {
            steps.sh "echo Deploying to STAGING server"
        } else if (env == 'prod') {
            steps.sh "echo Deploying to PRODUCTION server"
        }

        steps.echo "Deployment completed for ${env}"
    }

    // 🔄 Rollback Method
    def rollback(String env) {
        steps.echo "Rolling back deployment for ${env}..."

        steps.sh "echo Rolling back ${env} deployment"

        steps.echo "Rollback completed for ${env}"
    }
}