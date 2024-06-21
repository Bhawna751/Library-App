export const oktaConfig = {
    clientId:'0oahur4f99FHVQF4u5d7',
    issuer: 'https://dev-26144015.okta.com/oauth2/default',
    redirectUri: 'http://localhost:3000/login/callback',
    scopes: ['openid','profile','email'],
    pkce: true,
    disableHttpsCheck: true,
}