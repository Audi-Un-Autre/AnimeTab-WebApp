import { TestBed } from '@angular/core/testing';

import { AuthrouteLoginGuard } from './authroute-login.guard';

describe('AuthrouteGuard', () => {
  let guard: AuthrouteLoginGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(AuthrouteLoginGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
