pipeline {
    
    environment {
        githubcreds = 'soham-joshiGitHubPAT'
        imagename = "sohamjoshi/devops_calculator"
        registryCredential = "sohamjoshidockerhub"
        dockerImage = ''
        }
        
    agent any

    stages {
        
        stage('GitHub Pull Code') {
            steps {
                git([url: 'https://github.com/soham-joshi/devops_scientific_calculator.git', branch: 'main', credentialsId: githubcreds])
                // git branch: 'main', url: 'https://_@github.com/soham-joshi/devops_scientific_calculator.git'
            }
            
        }
        stage('Maven Build') {
            steps {
                script{
                    sh 'mvn clean install'
                }
            }
        }
        
        stage('Docker Build')
        {
            steps {
                // sh "docker build -t sohamjoshi/devops_calculator ."
                
                script{
                    dockerImage = docker.build imagename
                }
            }
        }
        
        stage('Docker Push')
        {
            steps{
                
                // sh 'docker push sohamjoshi/devops_calculator'
                script{
                    
                    docker.withRegistry( '', registryCredential ){
                    dockerImage.push()
                    }
                }
                
                
            }
        }
        
        stage('Ansible Pull Image') {
            steps {
                ansiblePlaybook colorized: true, disableHostKeyChecking: true, installation: 'Ansible', inventory: 'inventory', playbook: 'calc_deploy.yml'
                // ansiblePlaybook becomeUser: null, colorized: true, disableHostKeyChecking: true, installation: 'Ansible', inventory: 'inventory', playbook: 'calc_deploy.yml', sudoUser: null
            }    
        }
        
            
}
}
