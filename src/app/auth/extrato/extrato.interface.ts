import { ILancamento } from '../../shared/interfaces/dashboard.interface';

export interface IStatementByPeriod{
  sigla: string,
  dataInicio: string,
  dataFim: string
}

export interface IResponseStatement{
  lancamentos: ILancamento[]
  saldo: number
}
