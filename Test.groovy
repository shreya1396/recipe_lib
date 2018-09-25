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
	                    sed -i 's/$(GO) test -race $(pkgs)/$(GO) test $(pkgs)/' Mekefile.common
	                    make test
	                 '''
	                }
	              
	              } catch (err) {
	                currentBuild.result = 'FAILED'
	                throw err
	            }
	        }
	    }
