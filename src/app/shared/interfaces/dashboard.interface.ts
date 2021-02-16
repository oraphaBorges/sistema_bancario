export interface ITransaction{
  contaDestino: {
    login: string
    sigla: string
  },
  contaOrigem: {
    login: string
    sigla: string
  },

  date: Date,
  descricao: string,
  planoConta: string,
  valor: number
}

export interface IStatementByPeriod{
  sigla: string,
  dataInicio: Date,
  dataFim: Date
}
