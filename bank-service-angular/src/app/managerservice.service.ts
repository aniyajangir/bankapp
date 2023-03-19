import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Account } from './account';
import { Customer } from './customer';
import { Transaction } from './transaction';

@Injectable({
  providedIn: 'root'
})
export class ManagerserviceService {
  

  private baseUrl ="http://localhost:8080/user/dashboard"

  
  constructor(private httpClient:HttpClient) { }
  checkBalance(accountNumber:number ):Observable<string>{
    return this.httpClient.post(`${this.baseUrl}`+"/balance",accountNumber,{responseType:'text'});
  }
  deleteAccount(accountNumber: number):Observable<string>{
    return this.httpClient.post(`${this.baseUrl}`+"/deleteAccount",accountNumber,{responseType:'text'});
  }
  createAccount(account: Account):Observable<string>{
    return this.httpClient.post(`${this.baseUrl}`+"/createAccount",account,{responseType:'text'});
  }
  editAccount(account: Account):Observable<string>{
    return this.httpClient.post(`${this.baseUrl}`+"/editAccount",account,{responseType:'text'});
  }
  depositBalance(transaction: Transaction):Observable<string>{
    return this.httpClient.post(`${this.baseUrl}`+"/deposit",transaction,{responseType:'text'});
  }
  withdrawAmount(transaction: Transaction):Observable<string>{
    return this.httpClient.post(`${this.baseUrl}`+"/withdraw",transaction,{responseType:'text'});
  }
  createCustomer(customer: Customer):Observable<string>{
    return this.httpClient.post(`${this.baseUrl}`+"/createCustomer",customer,{responseType:'text'});
  }
  editCustomer(customer: Customer):Observable<string>{
    return this.httpClient.post(`${this.baseUrl}`+"/editCustomer",customer,{responseType:'text'});
  }
  deleteCustomer(customerId: number):Observable<string>{
    return this.httpClient.post(`${this.baseUrl}`+"/deleteCustomer",customerId,{responseType:'text'});
  }
  fundTransfer(transaction: Transaction):Observable<string>{
    return this.httpClient.post(`${this.baseUrl}`+"/fundTransfer",transaction,{responseType:'text'});
  }
  miniStatement(accountNumber: number):Observable<any>{
    return this.httpClient.post(`${this.baseUrl}`+"/ministatement",accountNumber);
  }
 
}
