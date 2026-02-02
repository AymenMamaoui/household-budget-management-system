import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class Token {

  private readonly TOKEN_KEY = 'auth-token';

  constructor() { }

  // Enregistre le token après un login réussi
  set token(token: string) {
    localStorage.setItem(this.TOKEN_KEY, token);
  }

  // Récupère le token pour l'envoyer au backend
  get token(): string | null {
    return localStorage.getItem(this.TOKEN_KEY);
  }

  // Supprime le token (Logout)
  removeToken(): void {
    localStorage.removeItem(this.TOKEN_KEY);
  }

  // Vérifie si un token existe (utile pour les Guards)
  isTokenValid(): boolean {
    const t = this.token;
    if (!t) return false;
    return true;
  }
  logout(): void {
    localStorage.removeItem('auth-token'); // Supprime le JWT
  }
}
