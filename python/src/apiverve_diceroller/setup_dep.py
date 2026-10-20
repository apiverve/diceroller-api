from setuptools import setup, find_packages

setup(
    name='apiverve_diceroller',
    version='1.2.2',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Dice Roller is a dice API that simulates RPG dice rolls using standard notation like 3d6 or 2d20 with optional modifiers. It outputs the individual die outcomes, die count, and the sum of all rolls.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/diceroller?utm_source=pypi&utm_medium=referral&utm_content=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
