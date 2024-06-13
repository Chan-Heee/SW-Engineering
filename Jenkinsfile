pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                // 소스코드 체크아웃
                checkout scm
            }
        }
        stage('Build') {
            steps {
                // Java 파일들을 컴파일하여 생성된 클래스 파일을 classes 디렉토리에 저장
                sh 'javac -encoding UTF-8 -d classes /**/*.java'
            }
        }
        stage('Test') {
            steps {
                 sh '''
                     java -cp "path/to/junit-platform-console-standalone.jar:classes" \
                     org.junit.platform.console.ConsoleLauncher \
                     --class-path classes \
                     --scan-class-path
                    '''
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: 'test_results.txt', allowEmptyArchive: true
        }
        failure {
            echo 'Build or test failed'
        }
        success {
            echo 'Build and test succeeded'
        }
    }
}