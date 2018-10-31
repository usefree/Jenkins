#!/usr/bin/env groovy
/*
Test Declarative pipeline
*/
//def ARRAY_OF_JOBS= ['/test3', '/test33']
def BUILD_SCRIPTS_GIT="https://github.com/usefree/bash.git"
def BUILD_SCRIPTS='mypipeline'
def BUILD_HOME='/var/lib/jenkins/workspace'
def tests = ['/test','/test3','/test4']

timestamps{
	node('master'){
		stage('Checkout: Code'){
			deleteDir() //delete workspace before start
			sh "mkdir -p $WORKSPACE/repo;\
			git config --global push.default simple;\
			git clone $BUILD_SCRIPTS_GIT $WORKSPACE/repo/$BUILD_SCRIPTS"
			sh "chmod -R +x $WORKSPACE/repo/$BUILD_SCRIPTS"
		}
		stage('find: ip') {
			println "some script execution here"
			//currentBuild.displayName = env.BUILD_NUM    
			//sh "$WORKSPACE/repo/$BUILD_SCRIPTS/find_my_ip.sh"
		}
		stage('build: job') {
			println "trying to build job test"
			for (test in tests) {
				try {
					build job: test
				}
				catch(Exception ex){
					println "exception below"
					println ex.getMessage() //show Exception
					println ex.getClass()
				}
				//finally{
				//	println "finaly step"
				//}
			}
		}
	}
}