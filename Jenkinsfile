pipeline {
    agent any
    stages {
        stage('Clone') {
            steps {
                git 'https://github.com/baby-venkatakumari/SeleniumProject.git'
            }
        }
        stage("Build") {
            steps{
                bat "mvn compile"
            }
        }
        stage("Test"){
            steps{
                bat "mvn test"
            }
        }
    }
        post{
                always {
                    publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, icon: '', keepAll: false, reportDir: 'target/surefire-reports', reportFiles: 'index.html', reportName: 'Pipeline HTML Report', reportTitles: '', useWrapperFileDirectly: true])
                }
            }
}
