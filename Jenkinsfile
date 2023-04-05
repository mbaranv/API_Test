pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn -f pom.xml -B -DskipTests clean package'
            }
            post {
                success {
                    echo "Now Archiving the Artifacts....."
                    archiveArtifacts artifacts: '**/*.jar'
                }
            }
        }
        stage('Test') {
            steps {
                sh 'mvn -f pom.xml clean test -Dtest=UserService'
            }
            post {
                always {
                    junit 'API_Test/target/surefire-reports/reports.xml'
                }
            }
        }
    }
}