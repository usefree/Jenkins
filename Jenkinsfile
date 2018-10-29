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
				git clone $BUILD_SCRIPTS_GIT repo/$BUILD_SCRIPTS"
				sh "chmod -R +x $WORKSPACE/repo/$BUILD_SCRIPTS"
			}
		}
		stage('find: ip') {
			steps {
				sh "sudo chmod +x $WORKSPACE/repo/$BUILD_SCRIPTS/find_my_ip.sh"
				sh "sudo $WORKSPACE/repo/$BUILD_SCRIPTS/find_my_ip.sh"
			}
		}
	}
	post {
		always {
			cleanWs()
		}
	}
}