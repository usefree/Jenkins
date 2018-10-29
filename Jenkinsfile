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
				sh "$WORKSPACE/repo/$BUILD_SCRIPTS/bash/find_my_ip.sh"
			}
		}
	}
	post {
		always {
			println "clean here"
			//cleanWs()
		}
	}
}