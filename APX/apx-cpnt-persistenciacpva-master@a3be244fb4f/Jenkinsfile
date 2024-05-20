#!groovy
// vim: ft=groovy
// These 2 need to be authorized using jenkins script approval
// http://your.jenkins.host/scriptApproval/
import groovy.json.JsonOutput
import java.util.Optional

/********** Global variables **********/

//Load environment variables
node {
  globalrepo = "${env.globalrepo}"
  globalrepo_credentials_id = "${env.globalrepo_credentials_id}"
  globalrepoBranch = "master"
  apx_node = "${env.apx_node_label}"
  projVerRepo = "${env.proj_ver_repo}"
  projVerRepoBucket = "${env.proj_ver_repo_bucket}"
  jenkinsProjVerCredentials = "${env.jenkins_proj_ver_credentials}"
  jenkinsSshCredentials = "${env.jenkins_ssh_credentials}"
  jenkinsArtifactoryCredentials = "${env.jenkins_artifactory_credentials}"
  artifactoryServer = "${env.artifactory_server}"
  componentPaaSId = "persistenciacpva"
  appPaaSId = "co-punto-venta-aliados-dtos"
  proyectPaaSId = "co-punto-venta-aliados"

}

def params = [
  'component' : 'uf',
  "dockerImage" : "registry.paasespro12.ext.es.iaas.igrupobbva:443/apx/devops/",
  'repoBranch' : '${env.BRANCH_NAME}',
  'repoName' : 'FNGHC_APX_CPNT_persistenciacpva',
  'projectVersion' : '${env.BRANCH_NAME}',
  'slave_label' : '${apx_node}',
  'upload_artifactory' : true,
  'extra_properties' : null,
  'apxrepoBranch' : 'master',
  'uuaa' : 'WIKJ'
]

fileLoader.withGit(globalrepo, globalrepoBranch, globalrepo_credentials_id, apx_node) {
  stage name: "Checkout Global Library"
  apx_ci = fileLoader.load('src/apx/ci/ci');
  apx_ci.apx_ci_flow(params)
}