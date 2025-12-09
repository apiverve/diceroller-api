from setuptools import setup, find_packages

setup(
    name='apiverve_diceroller',
    version='1.1.12',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Dice Roller is a tool for rolling dice using standard RPG notation (XdY format). It supports multiple dice, various die sizes, modifiers, and provides statistics including min, max, average, and theoretical values for gaming and simulations.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
