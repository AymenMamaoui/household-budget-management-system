export interface RegisterRequest {
  firstname: string;
  lastname: string;
  email: string;
  password: string;
  role: string;
  household_id: string;
}

export interface AuthenticationRequest {
  email: string;
  password: string;
}
