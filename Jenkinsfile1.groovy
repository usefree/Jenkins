#!/usr/bin/env groovy
/*
Test Declarative pipeline
*/
//def ARRAY_OF_JOBS= ['/test3', '/test33']
def BUILD_SCRIPTS_GIT="https://github.com/usefree/c-"
def BUILD_SCRIPTS='mypipeline'
def BUILD_HOME='/var/lib/jenkins/workspace'
def tests = ['/test','/test3']
def CustomWorkspace = "/home/usefree/workspace"

timestamps{
	node('master'){
		stage('Checkout: Code'){
			deleteDir() //delete workspace before start
			sh "mkdir -p $WORKSPACE/repo;\
			git config --global push.default simple;\
			git clone $BUILD_SCRIPTS_GIT $WORKSPACE/repo/$BUILD_SCRIPTS"
			sh "chmod +x $WORKSPACE/repo/$BUILD_SCRIPTS/build.sh"
		}
		stage('build: restore') {
			println "try build with dotnet core"
			sh "cd $WORKSPACE/repo/$BUILD_SCRIPTS/src/firstapp/"
			println "dotnet restore $WORKSPACE/repo/$BUILD_SCRIPTS/src/firstapp.sln"
			sh "dotnet restore $WORKSPACE/repo/$BUILD_SCRIPTS/src/firstapp.sln"
			println "dotnet publish $WORKSPACE/repo/$BUILD_SCRIPTS/src/firstapp.sln"
			sh "dotnet publish $WORKSPACE/repo/$BUILD_SCRIPTS/src/firstapp.sln"
			println "dotnet build $WORKSPACE/repo/$BUILD_SCRIPTS/src/firstapp.sln"
			sh "dotnet build $WORKSPACE/repo/$BUILD_SCRIPTS/src/firstapp.sln"
			//sh "$WORKSPACE/repo/$BUILD_SCRIPTS/build.sh"
			//currentBuild.displayName = env.BUILD_NUM    
			//sh "$WORKSPACE/repo/$BUILD_SCRIPTS/find_my_ip.sh"
		}
		stage('build: publish') {
			println "just another step"
			//println "trying to build job test"
			//println "env.Workspace is ${env.WORKSPACE}"
			//println "workspace is: ${WORKSPACE}"
			//println "changing workspace to ${CustomWorkspace}"
			//env.WORKSPACE = CustomWorkspace
			//println "env.workspace is: ${env.WORKSPACE}"
			//WORKSPACE = env.WORKSPACE
			//println "Workspace is ${WORKSPACE}"
			//println "${BUILD_NUMBER}"
			//for (test in tests) {
			//	try {
			//		build job: test
			//	}
			//	catch(Exception ex){
			//		println "exception below"
			//		println ex.getMessage() //show Exception
			//	}
				//finally{
				//	println "finaly step"
				//}
			//}
		}
	}
}