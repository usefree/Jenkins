#!/usr/bin/env groovy
/*
Test Declarative pipeline
*/
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
					currentBuild.displayName = env.BUILD_NUM    //Set Build name
					//sh "$WORKSPACE/repo/$BUILD_SCRIPTS/find_my_ip.sh"
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
