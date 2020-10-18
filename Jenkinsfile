import java.text.SimpleDateFormat
import jenkins.model.Jenkins
import hudson.model.*
            
node('master') {
    try{
       
        //Tools
        env.JAVA_HOME="${tool 'openjdk-8'}"
        env.GRADLE="${tool 'gradle-6-7'}"        
	env.SONAR_SCANNER="${tool 'sonarqube-scanner'}";
        
	env.errorEncontrado = ""
    
        properties([
            buildDiscarder(
                logRotator(
                    numToKeepStr: '3'
                )
            ),
            disableConcurrentBuilds()            
        ])
        
	stage('Checkout') {
        	echo "####################->Init Checkout<-####################"
            checkout()
            echo "####################->End Checkout<-####################"
        }
	    
        stage('Clean') {
        	echo "####################->Init Clean<-####################"
		sh 'ls -l'
		sh 'id'
	    sh 'chmod +x gradlew'
		sh 'ls -l'		
            sh './gradle clean'
            echo "####################->End Clean<-####################"
        }
        
        stage('Compile') {
        	echo "####################->Init Compile<-####################"
            sh './gradle compileJava'
            echo "####################->End Compile<-####################"
        }
			
	stage('Test') {
        	echo "####################->Init Unit Test<-####################"
            sh './gradle test'
            junit '**/build/test-results/test/*.xml'
            echo "####################->End Unit Test<-####################"
        }
	    
       stage('Build') {
        	echo "####################->Init Build<-####################"
           sh './gradle build -x test'
            echo "####################->End Build<-####################"
        }        
        
    }catch(err){
        echo "Hubo un error en el pipeline"
        env.errorEncontrado = err.getMessage()
        echo env.errorEncontrado
        currentBuild.result = 'FAILURE'
    }
    
}// fin node

def checkout(){
    checkout([
                $class: 'GitSCM',
                branches: [[
                    name: '*/master'
                ]],
                doGenerateSubmoduleConfigurations: false, 
                extensions: [],
                gitTool: 'git', 
                submoduleCfg: [], 
                userRemoteConfigs: [[
                    credentialsId: 'github_personal', 
                    url: 'https://github.com/JULIANCHO923/CalculadoraAPI'
                ]]
            ])
}
