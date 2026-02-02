import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RegisterRequest, AuthenticationRequest } from '../../models/auth-request.model';
import { AuthenticationResponse } from '../../models/auth-response.model';

@Injectable({
  providedIn: 'root'
})
export class Auth {
  // URL de l'API Spring Boot
  private readonly baseUrl = 'http://localhost:8080/api/auth';

  constructor(private http: HttpClient) {}

  // Méthode pour l'inscription
  register(request: RegisterRequest): Observable<AuthenticationResponse> {
    return this.http.post<AuthenticationResponse>(`${this.baseUrl}/register`, request);
  }

  // Méthode pour la connexion
  login(request: AuthenticationRequest): Observable<AuthenticationResponse> {
    return this.http.post<AuthenticationResponse>(`${this.baseUrl}/login`, request);
  }
}
