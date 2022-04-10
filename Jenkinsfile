pipeline {
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
    }
}
