#!/usr/bin/env groovy
/*
Test Declarative pipeline
*/
//def ARRAY_OF_JOBS= ['/test3', '/test33']
pipeline {
		environment {
			BUILD_SCRIPTS_GIT="https://github.com/usefree/bash.git"
			BUILD_SCRIPTS='mypipeline'
			BUILD_HOME='/var/lib/jenkins/workspace'
		}
		agent any
		options { timestamps() }
		stages {
			stage('Checkout: Code') {
				steps {
					sh "mkdir -p $WORKSPACE/repo;\
					git config --global push.default simple;\
					git clone $BUILD_SCRIPTS_GIT $WORKSPACE/repo/$BUILD_SCRIPTS"
					sh "chmod -R +x $WORKSPACE/repo/$BUILD_SCRIPTS"
				}
			}
			stage('find: ip') {
				steps {
					println "some script execution here"
					//currentBuild.displayName = env.BUILD_NUM    
					//sh "$WORKSPACE/repo/$BUILD_SCRIPTS/find_my_ip.sh"
				}
			}
			stage('build: job') {
				steps {
					println "trying to build job test"
					try {
						build job: '/test3'
						build job: '/test33'
					}
					catch(Exception ex){
						println ex.getMessage() //show Exception
					}
					finally{
						println "finaly step"
					}
				}
			}
		}
		post {
			always {
				println "clean here"
				cleanWs()
			}
		}
	}
