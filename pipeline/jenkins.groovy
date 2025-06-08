pipeline {
    agent any

    parameters {
        choice(
            name: 'OS',
            choices: ['linux', 'darwin', 'windows'],
            description: 'Target operating system'
        )
        choice(
            name: 'ARCH',
            choices: ['amd64', 'arm64'],
            description: 'Target architecture'
        )
        booleanParam(
            name: 'SKIP_TESTS',
            defaultValue: false,
            description: 'Skip running tests'
        )
        booleanParam(
            name: 'SKIP_LINT',
            defaultValue: false,
            description: 'Skip running linter'
        )
    }

    stages {
        stage('Example') {
            steps {
                echo "Selected OS: ${params.OS}"
                echo "Selected ARCH: ${params.ARCH}"
                echo "Skip Tests: ${params.SKIP_TESTS}"
                echo "Skip Lint: ${params.SKIP_LINT}"
            }
        }
    }
}
