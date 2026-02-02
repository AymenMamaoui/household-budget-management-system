import {Budget} from './budget.model';

export interface Transaction {
  id?: number;
  description: string;
  amount: number;
  date: Date;
  budget?: Budget;
  user?: any;
}
