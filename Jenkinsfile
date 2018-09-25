@Library("recipe-library") _
    Install {
        projectName = "Project1"
        serverDomain = "Project1 Server Domain"
    }
pipeline {
  agent any
  environment {   
                    GOPATH = "/home/jenkins"
                    PATH = "$PATH" + "${GOPATH}/bin:/usr/lib/go-1.10/bin"
                    
                      
    }
  stages {
    stage('execute') {
      steps {
        echo 'the job is executing'
      }
    }
  }
}
