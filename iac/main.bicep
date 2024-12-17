param applicationName string
param componentName string
param env string
param uniqueDeployId string
param postfixCount string
param location string
param aadAppClientId string
param tags object
param developerAccessAadGroupId string
param useLocalKeyVault bool = false
param useGlobalKeyVault bool = false
param internalNetworkName string = ''
param allowVnetUsage bool = false

module functionAppModule '../common-repo/Source/IaC/shared_modules/dih-functionapp.bicep' = {
  name: 'functionApp'
  params: {
    applicationName: applicationName
    componentName: componentName
    env: env
    postfixCount: postfixCount
    uniqueDeployId: uniqueDeployId
    location: location
    tags: tags
    customSettings: []
    aadAppClientId: aadAppClientId
    developerAccessAadGroupId: developerAccessAadGroupId
    useLocalKeyVault: useLocalKeyVault
    useGlobalKeyVault: useGlobalKeyVault
    allowVnetUsage: allowVnetUsage
    internalNetworkName: internalNetworkName
  }
}

output functionAppName string = functionAppModule.outputs.functionAppName
