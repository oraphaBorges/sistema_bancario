export const headersDefault = (tokenSection) => {
    let headersApp = {
        headers: {
            'Content-Type': 'application/json',
            'Authorization': tokenSection
        }
    }

    return headersApp;
} 

export const headersDefaultNoAuth = {
    headers: {
        'Content-Type': 'application/json'
    }
}