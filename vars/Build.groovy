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
                 mkdir -p $GOPATH/src/github.com/prometheus
                 cd $GOPATH/src/github.com/prometheus
                 git clone https://github.com/prometheus/prometheus.git
                 cd prometheus
                 git checkout v2.3.2
                 make build
                 '''
                }
              
              } catch (err) {
                currentBuild.result = 'FAILED'
                throw err
            }
        }
    }
