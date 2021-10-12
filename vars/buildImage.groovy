#!/usr/bin/env groovy
def call() {
echo "building the image..."
    withCredentials([usernamePassword(credentialID: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
          sh 'docker build -t phyllisn/demo-app:java-maven-app-2.0 .'
          sh "echo $PASS | docker login -u $USER --password-stdin"
        //sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin 167.99.241.123:8083" (for any other registry than dockerhub)
          sh 'docker push phyllisn/demo-app:java-maven-app-2.0'
    }
}

------------------------------------------------
//11b: defining call method with parameter type:
------------------------------------------------
#!/usr/bin/env groovy
def call(String imageName) {
    echo "building the image..."
    withCredentials([usernamePassword(credentialID: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
          sh "docker build -t $imageName ."
          sh "echo $PASS | docker login -u $USER --password-stdin"
        //sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin 167.99.241.123:8083" (for any other registry than dockerhub)
          sh "docker push $imageName"
    }
}

