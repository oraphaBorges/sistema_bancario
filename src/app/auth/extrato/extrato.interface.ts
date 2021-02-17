import { ILancamento } from '../../shared/interfaces/dashboard.interface';

export interface IStatementByPeriod{
  sigla: string,
  dataInicio: Date,
  dataFim: Date
}

export interface IResponseStatement{
  lancamentos: ILancamento[]
  saldo: number
}
