pipeline {

    agent any

    tools {
        gradle 'gradle'
    }

    stages {
        stage('build') {
            steps {
                sh 'gradle build'
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
