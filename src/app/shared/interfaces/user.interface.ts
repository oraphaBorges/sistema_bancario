//mover interfaces de acordo com as individualidades, se necessário
export interface ISession{
  dataInicio: string,
  dataFim: string,
  token: string,
  login: string
}

export interface IRegister{
  cpf: string,
  login: string,
  nome: string,
  senha: string
}

export interface ILogin{
  usuario: string,
  senha: string
}
