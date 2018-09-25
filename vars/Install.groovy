def call(body) {

        def config = [:]
        body.resolveStrategy = Closure.DELEGATE_FIRST
        body.delegate = config
        body()

        node {
            // Clean workspace before doing anything
            deleteDir()

            try {
                stage ('Build') {
                    sh '''
                 sudo apt-get update
            	   sudo apt-get install -y make cmake gcc g++ wget tar git curl
            	   sudo apt-get install -y golang-1.10
                 '''
                }
              
              } catch (err) {
                currentBuild.result = 'FAILED'
                throw err
            }
        }
    }
