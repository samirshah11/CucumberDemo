pipeline{
    agent any
    stages{
        stage('Build project jar'){
            steps{
                bat 'mvn clean package -DskipTests'
            }
         }
        stage("Building docker image"){
            steps{
                bat "docker build -t=samirshh9/selenium-docker ."
            }

        }

        stage("push image to docker hub"){
            steps{
                 withCredentials([usernameColonPassword(credentialsId: 'DH', usernameVariable: 'Username',passwordVariable: 'Password')]){
                 bat "docker login --username=$Username --password=$Password"
                 bat "docker push samirshh9/selenium-docker:latest"
                 }
            }

        }

    }
}
