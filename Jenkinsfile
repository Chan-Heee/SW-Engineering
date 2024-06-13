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
                sh 'javac -encoding UTF-8 -d classes main/*.java'
            }
        }
        stage('Test') {
            steps {
                // JUnit 5 테스트 실행을 위한 classpath 설정
                def classpath = "classes:lib/junit-platform-console-standalone-1.7.1.jar"

                // JUnit 5 테스트 실행
                sh "java -cp ${classpath} org.junit.platform.console.ConsoleLauncher --scan-classpath > test_results.txt"
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