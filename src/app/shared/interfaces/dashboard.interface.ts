export interface IAccount{
  CORRENTE: {
      id: number,
      type: string,
      icon: string,
      colorValue: string,
      saldo: number,
      lancamentos: ILancamento[]
  },

  POUPANCA: {
    id: number,
    type: string,
    icon: string,
    colorValue: string,
    saldo: number,
    lancamentos: ILancamento[]
  },

  CREDITO: {
    id: number,
    type: string,
    icon: string,
    colorValue: string,
    saldo: number,
    lancamentos: ILancamento[]
  }
}

export interface IAccountResponse{
  id: number,
  tipo: string,
  saldo: number,
  lancamentos: ILancamento[]
}

export interface ILancamento{
    date: Date,
    descricao: string,
    valor: number,
    planoConta:string,
    contaOrigem:{
      login:string,
      sigla:string
    },
    contaDestino:{
      login:string,
      sigla:string
    },
}

export interface IAccountPlan{
  finalidade: string,
  login: string,
}
