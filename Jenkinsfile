pipeline {

    agent any

    stages {
        stage('build') {
            steps {
                sh './gradlew'
            }
        }
    }

    post {
        always {
            deleteDir()
        }
        success {
            echo 'Yo, man!'
        }
        unstable {
            echo 'WTF?!'
        }
        failure {
            echo 'OMFG!!!'
        }
    }

}
