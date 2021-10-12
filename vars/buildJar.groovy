#!/usr/bin/env groovy  // to let your jenkinfile editor detect that it is a groovy script since the vars folder does not gave a .groovy extension

def call() {
    //where we implement the function logic
    echo "building the application..."
    sh 'mvn package'
}

-------------------------------------------------------------------
// accessing global variables eg. check the branch that is building
--------------------------------------------------------------------
#!/usr/bin/env groovy

def call() {
    echo "building the application for branch $BRANCH_NAME"
    sh 'mvn package'
}
