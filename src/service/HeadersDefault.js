export const HeadersDefault = (tokenSection) => {
    let headersApp = {
        headers: {
            'Content-Type': 'application/json',
            'Authorization': tokenSection
        }
    }

    return headersApp;
} 

export const HeadersDefaultNoAuth = {
    headers: {
        'Content-Type': 'application/json'
    }
}