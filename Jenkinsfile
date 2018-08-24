node {
        def mavenImageName = "maven_image:${env.BUILD_NUMBER}"
        def backendImageName = "lsantamaria/demo-spring-boot:${env.BUILD_NUMBER}"
        def mavenImage
        def backendImage

        stage('Clone repository') {
            checkout scm
        }
        stage("Build Docker image"){
            mavenImage = docker.build(mavenImageName, "-f Dockerfile-maven .")
        }
        stage("Build") {
            mavenImage.inside{
                sh 'mvn -B compile'
            }
        }
        stage("Test") {
            mavenImage.inside{
                sh 'mvn -B test'
            }
        }
        stage("Package") {
            mavenImage.inside{
                sh 'mvn -B package -DskipTests'
                stash includes: 'target/*.jar', name: 'targetfiles'
            }
        }
        stage("Run image"){
            unstash 'targetfiles'
            backendImage = docker.build(backendImageName, "-f Dockerfile .")
        }

        stage('Push image') {
            docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
                backendImage.push("${env.BUILD_NUMBER}")
                backendImage.push("latest")
            }
        }
}
