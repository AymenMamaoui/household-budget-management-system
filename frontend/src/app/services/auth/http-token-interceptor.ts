import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { Token } from '../token/token';

export const httpTokenInterceptor: HttpInterceptorFn = (req, next) => {
  const tokenService = inject(Token);
  const token = tokenService.token;

  // Si un token existe, on clone la requête pour y ajouter le header
  if (token) {
    const authReq = req.clone({
      setHeaders: {
        Authorization: `Bearer ${token}`
      }
    });
    return next(authReq);
  }

  // Sinon, on laisse passer la requête telle quelle
  return next(req);
};
