
pipeline {
    agent any

    environment {
        COLLECTION = 'Library.postman_collection.json'
        ENVIRONMENT = 'Library-Test.postman_environment.json'
        REPORT_DIR = 'newman'
        REPORT_FILE = 'Library_Report.html'
    }

    stages {
        stage('Checkout') {
            steps {
                echo '📥 Checking out source code...'
                checkout scm
            }
        }

        stage('Install Newman') {
            steps {
                echo '📦 Installing Newman and HTML Extra Reporter...'
                sh 'npm install -g newman newman-reporter-htmlextra'
            }
        }

        stage('Run API Tests') {
            steps {
                echo '🧪 Running Postman Collection using Newman...'
                sh '''
                mkdir -p $REPORT_DIR
                newman run $COLLECTION \
                    -e $ENVIRONMENT \
                    -r cli,htmlextra \
                    --reporter-htmlextra-export $REPORT_DIR/$REPORT_FILE
                '''
            }
        }

        stage('Publish HTML Report') {
            steps {
                echo '📤 Publishing Newman HTML report...'
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: '$REPORT_DIR',
                    reportFiles: '$REPORT_FILE',
                    reportName: 'Newman HTML Report'
                ])
            }
        }
    }

    post {
        always {
            echo '🧹 Cleaning up workspace...'
            deleteDir()
        }
    }
}
