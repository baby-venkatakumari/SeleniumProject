import { test, expect } from '@playwright/test';

test('EPAM Services -> Explore Our Client Work shows Client Work text', async ({ page }) => {
  await page.goto('https://www.epam.com/');

  const servicesMenu = page.getByRole('link', { name: /^Services$/ });
  await servicesMenu.hover();

  const clientWorkLink = page.getByRole('link', { name: /Explore Our Client Work/i });
  await expect(clientWorkLink).toBeVisible();
  await clientWorkLink.click();

  await expect(page.getByText('Client Work', { exact: false })).toBeVisible();
});
