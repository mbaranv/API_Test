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
                sh 'mvn install clean test -Dtest=UserService'
            }
            post {
                always {
                    junit 'target/surefire-reports/reports.xml'
                }
            }
        }
    }
}