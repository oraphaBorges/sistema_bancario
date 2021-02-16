export interface ILoginCredencials{
    usuario:string,
    senha:string
}

export interface ILoginResponse{
    login:string
    dataFim: Date,
    dataInicio: Date,
    token: string,
} 