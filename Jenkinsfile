pipeline {
    environment{

    registry ="cristiano10/calculator_roopam"
    registryCredential= 'docker-cred'
    dockerImage=''
    }
    agent any
    stages{
        stage('step 1 git pull'){
            steps {
                git url: 'https://github.com/Roopam10/miniproject_MT2021110.git', branch: 'master',
                credentialsId: 'git-cred'
            }
        }
        stage('step 2 Build maven'){
            steps {
                sh "mvn -B -DskipTests clean package"
            }
        }

        stage('step 3 Test'){
            steps {
                sh "mvn test"
            }
        }
        stage('step 4 building docker image')
        {
        steps{
            script{
                dockerImage=docker.build registry + ":latest"
                }
            }
        }
        stage('step 5 push docker image to dockerhub')
        {
        steps{
            script{
                docker.withRegistry('', registryCredential){
                dockerImage.push()
                }
            }
        }
        }
        stage('step 6 ansible image deploy'){
            steps{
                ansiblePlaybook becomeUser: null, colorized: true,disableHostKeyChecking: true, installation: 'Ansible', inventory:'ansible-docker-deploy/inventory' ,playbook: ' ansible-docker-deploy/deploy-image.yml' , sudoUser:null
            }
        }
        stage('step 7 ansible container creation'){
                    steps{
                        ansiblePlaybook becomeUser: null, colorized: true,disableHostKeyChecking: true, installation: 'Ansible', inventory:'ansible-docker-deploy/inventory' ,playbook: ' ansible-docker-deploy/create-container.yml' , sudoUser:null
                    }
                }
    }
}
