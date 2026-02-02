export interface User {
  id?: number;
  firstname: string;
  lastname: string;
  email: string;
  role: string;
  householdId: string; // Correspond à household_id côté backend
}
