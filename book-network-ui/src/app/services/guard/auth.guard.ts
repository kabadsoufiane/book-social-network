import {CanActivateFn, Router} from '@angular/router';
import {inject} from "@angular/core";
import {TokenService} from "../token/token.service";

export const authGuard: CanActivateFn = () => {
  const tokenService = inject(TokenService);
  const router : Router = inject(Router);
  if(tokenService.isTokenNonValid()) {
    router.navigate(['login']);
    return false;
  }
  return true;
};
